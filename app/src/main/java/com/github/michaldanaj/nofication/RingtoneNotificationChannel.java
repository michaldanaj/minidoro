package com.github.michaldanaj.minidoro.nofication;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import com.github.michaldanaj.minidoro.R;
import com.github.michaldanaj.minidoro.prefs.AppPreferences;
import com.github.michaldanaj.minidoro.prefs.NotificationPreferences;

/*
 * Proxy decorator for default notification preference strategy
 */
@TargetApi(26)
public class RingtoneNotificationChannel implements NotificationPreferences
{
	private final ChannelInfo info;
	private final NotificationManager notificationManager;
	private final AppPreferences.RingtoneSharedPreferences nonChannelImpl;

	public RingtoneNotificationChannel(Context ctx, AppPreferences.RingtoneSharedPreferences p)
	{
		nonChannelImpl = p;
		notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
		info = new ChannelDescriptor.ChannelInfo(
		   ctx.getResources().getString(R.string.nChannelBellId),
		   ctx.getResources().getString(R.string.nChannelBellName)
		);
	}

	private NotificationChannel getChannel()
	{
		return notificationManager.getNotificationChannel(info.id);
	}

	@Override
	public ChannelInfo getChannelInfo() { return info; }

	@Override
	public Uri getRingtone() { return nonChannelImpl.getRingtone(); }

	@Override
	public boolean isRingtoneDefault()
	{
		NotificationChannel c = getChannel();
		if (c != null) {
			return c.getSound().equals(nonChannelImpl.minidoroRingtone);
		}
		return nonChannelImpl.isRingtoneDefault();
	}

	@Override
	public boolean isDirectChangeAvailable() { return getChannel() == null; }
}
