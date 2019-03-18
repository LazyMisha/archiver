package com.project.command;

import com.project.service.ConsoleHelper;
import com.project.utils.TextManager;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(TextManager.getText("bye"));
    }
}
