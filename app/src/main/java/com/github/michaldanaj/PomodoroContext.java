package com.github.michaldanaj.minidoro;

import com.github.michaldanaj.minidoro.dnd.DndManager;
import com.github.michaldanaj.minidoro.dnd.RingerModeManager;

/**
 * This class encapsulates all the app state (logic and auxiliary things)
 */
public class PomodoroContext
{
	PomodoroState pomodoroState;
	RingerModeManager ringerModeManager;
	DndManager dndManager;
}
