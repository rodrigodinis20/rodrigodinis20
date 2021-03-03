package org.academiadecodigo.mvc;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.util.HashSet;

public class Question {
   protected MenuInputScanner joinTeam;
   public StringInputScanner nameQuestion;

    public Question() {
        joinTeam = new MenuInputScanner(Message.yesOrNoOptions);
        joinTeam.setMessage(Message.wwelcome);

        nameQuestion = new StringInputScanner();
        nameQuestion.setMessage(Message.nameQuestion);

    }

    public MenuInputScanner getJoinTeam() {
        return joinTeam;
    }

    public StringInputScanner getNameQuestion() {
        return nameQuestion;
    }
}
