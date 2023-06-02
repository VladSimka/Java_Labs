package by.vladsimonenko.twelfthlab.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InfoForDataBase {
    List<Word> info;

    public InfoForDataBase() {
        info = new ArrayList<>();
        info.add(new Word("good", "добры"));
        info.add(new Word("good", "харошы"));
        info.add(new Word("bad", "пякучы"));
        info.add(new Word("boy", "хлопец"));
        info.add(new Word("girl", "дзяўчыня"));
        info.add(new Word("drink", "піць"));
        info.add(new Word("home", "дом"));
        info.add(new Word("happy", "водрадны"));
        info.add(new Word("happy", "шчаслівы"));
        info.add(new Word("read", "чытаць"));
        info.add(new Word("life", "жыццё"));
        info.add(new Word("live", "жыць"));
        info.add(new Word("walk", "ходзіць"));
        info.add(new Word("table", "стол"));
        info.add(new Word("light", "свет"));
        info.add(new Word("fail", "няўдачыць"));
        info.add(new Word("wall", "стэна"));
        info.add(new Word("weather", "пагода"));
        info.add(new Word("speak", "размаўляць"));
        info.add(new Word("understand", "разумець"));
        info.add(new Word("think", "думаць"));
        info.add(new Word("write", "пісаць"));
        info.add(new Word("white", "белы"));
        info.add(new Word("yellow", "жоўты"));
    }

    public List<Word> getInfo() {
        return info;
    }
}
