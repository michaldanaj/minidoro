package com.github.michaldanaj.minidoro.prefs;

import com.github.michaldanaj.minidoro.nofication.ChannelDescriptor;

public interface NotificationPreferences extends ChannelDescriptor
{
	boolean isRingtoneDefault();
	boolean isDirectChangeAvailable();
}