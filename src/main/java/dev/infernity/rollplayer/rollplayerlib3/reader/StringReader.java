package dev.infernity.rollplayer.rollplayerlib3.reader;

import org.rekex.helper.anno.Str;

import java.util.List;

public class StringReader implements Reader<String, Character> {
    String string;
    int index = 0;

    public StringReader(String string) {
        this.string = string;
    }

    public void skipWhitespace() {
        while(this.peek() != null && Character.isWhitespace(this.peek())) {
            this.read();
        }
    }

    @Override
    public Character read() {
        try {
            return this.string.charAt(this.index++);
        } catch (StringIndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public Character peek() {
        try {
            return this.string.charAt(this.index);
        } catch (StringIndexOutOfBoundsException e) {
            return null;
        }
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
    public void backtrackBy(int amount) {
        this.index -= amount;
    }

    @Override
    public String toString() {
        return "StringReader{index=" + this.index + ", string='" + this.string + '\'' + '}';
    }
}
