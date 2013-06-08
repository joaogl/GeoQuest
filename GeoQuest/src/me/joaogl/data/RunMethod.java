package me.joaogl.data;

import me.joaogl.launcher.Launcher;
import me.joaogl.game.question.Questions1;

public class RunMethod {
	public static void main(String[] args) {
		if (ProgramInfo.debugging) new Questions1();
		else new Launcher();
	}
}