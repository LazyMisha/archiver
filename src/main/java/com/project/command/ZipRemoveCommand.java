package com.project.command;

import com.project.service.ConsoleHelper;
import com.project.service.ZipFileManager;
import com.project.utils.TextManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage(TextManager.getText("remove_file_from_archive"));

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage(TextManager.getText("type_fullPath_in_archive"));
        Path sourcePath = Paths.get(ConsoleHelper.readString());
        zipFileManager.removeFile(sourcePath);

        ConsoleHelper.writeMessage(TextManager.getText("remove_done"));
    }
}