package com.example.maps1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import com.example.maps1.ui.theme.Maps1Theme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng

class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var pinnedLocation: LatLng? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Request location permissions
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    showToast("Location permission granted.")
                }
                else -> {
                    showToast("Location permission denied.")
                }
            }
        }

        locationPermissionRequest.launch(
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
        )

        setContent {
            Maps1Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = { innerPadding ->
                        MainScreen(
                            modifier = Modifier.padding(innerPadding),
                            onPinLocation = { pinLocation() },
                            onGoToPinnedLocation = { goToPinnedLocation() },
                            onGetDirections = { openDirections() }
                        )
                    }
                )
            }
        }
    }

    private fun pinLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                pinnedLocation = LatLng(it.latitude, it.longitude)
                showToast("Location pinned: ${it.latitude}, ${it.longitude}")
            }
        }
    }

    private fun goToPinnedLocation() {
        pinnedLocation?.let {
            showToast("Moving to pinned location: ${it.latitude}, ${it.longitude}")
            // Open the pinned location in Google Maps
            val gMapsUri = "https://www.google.co.in/maps/place/SRM+Ramapuram+-+Management+Studies/@13.0337763,80.1774251,17z/data=!3m1!4b1!4m6!3m5!1s0x3a526190e0c923d3:0x446467305748"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(gMapsUri))
            startActivity(intent)
        } ?: showToast("No location pinned.")
    }

    private fun openDirections() {
        pinnedLocation?.let { pinned ->
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    val currentLocation = LatLng(it.latitude, it.longitude)
                    // Open directions from the current location to the pinned location
                    val uri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=\${currentLocation.latitude},${currentLocation.longitude}&destination=${pinned.latitude},${pinned.longitude}&travelmode=driving")
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    startActivity(intent)
                }
            }
        } ?: showToast("No pinned location to get directions from.")
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onPinLocation: () -> Unit,
    onGoToPinnedLocation: () -> Unit,
    onGetDirections: () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        Button(onClick = onPinLocation, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "Pin My Location")
        }

        Button(onClick = onGoToPinnedLocation, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "Go to Pinned Location")
        }

        Button(onClick = onGetDirections, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "Get Directions")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Maps1Theme {
        MainScreen(
            onPinLocation = {},
            onGoToPinnedLocation = {},
            onGetDirections = {}
            )
        }
}