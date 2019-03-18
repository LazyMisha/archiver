package com.project.command;

import com.project.exception.PathIsNotFoundException;
import com.project.service.ConsoleHelper;
import com.project.service.ZipFileManager;
import com.project.utils.TextManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage(TextManager.getText("create_archive"));

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage(TextManager.getText("type_fullName_path_message"));
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(sourcePath);

            ConsoleHelper.writeMessage(TextManager.getText("create_done"));

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeErrorMessage(TextManager.getText("wrong_name_of_directory"));
        }
    }
}
