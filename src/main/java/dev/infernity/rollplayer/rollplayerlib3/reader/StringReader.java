package dev.infernity.rollplayer.rollplayerlib3.reader;

import org.rekex.helper.anno.Str;

import java.util.List;

public class StringReader implements Reader<String, Character> {
    String string;
    int index = 0;

    public StringReader(String string) {
        this.string = string;
    }

    @Override
    public Character read() {
        return this.string.charAt(this.index++);
    }

    @Override
    public Character peek() {
        return this.string.charAt(this.index);
    }

    @Override
    public String getSource() {
        return this.string;
    }

    @Override
    public int index() {
        return this.index;
    }

    @Override
    public String toString() {
        return "StringReader{index=" + this.index + ", string='" + this.string + '\'' + '}';
    }
}
