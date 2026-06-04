package com.example.techcareservices;

import java.util.ArrayList;

/**
 * This class handles the global storage of bookings.
 * By using 'static', the data stays in the app's memory
 * even when you switch between Admin and Customer screens.
 */
public class BookingData {
    // The central list where all repair requests are stored
    public static ArrayList<String> allBookings = new ArrayList<>();
}