package com.project.command;

import com.project.service.ConsoleHelper;
import com.project.service.FileProperties;
import com.project.service.ZipFileManager;
import com.project.utils.TextManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage(TextManager.getText("check_archive"));

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage(TextManager.getText("archive_contains"));

        List<FileProperties> files = zipFileManager.getFilesList();

        for (FileProperties file : files) {
            ConsoleHelper.writeMessage(file.toString());
        }

        ConsoleHelper.writeMessage(TextManager.getText("check_archive_done"));
    }
}
