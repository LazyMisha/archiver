package com.project.command;

import com.project.service.ConsoleHelper;
import com.project.service.ZipFileManager;
import com.project.utils.TextManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage(TextManager.getText("type_fullPath_archive_message"));
        Path zipPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(zipPath);
    }
}