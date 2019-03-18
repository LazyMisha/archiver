package com.project.command;

import com.project.exception.PathIsNotFoundException;
import com.project.service.ConsoleHelper;
import com.project.service.ZipFileManager;
import com.project.utils.TextManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipAddCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage(TextManager.getText("add_file_command"));

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage(TextManager.getText("type_fullName_message"));
            Path sourcePath = Paths.get(ConsoleHelper.readString());

            zipFileManager.addFile(sourcePath);

            ConsoleHelper.writeMessage(TextManager.getText("add_completed_message"));

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeErrorMessage(TextManager.getText("file_not_found"));
        }
    }
}
