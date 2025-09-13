package dev.infernity.rollplayer.rollplayerlib3.parser;

import dev.infernity.rollplayer.rollplayerlib3.reader.StringReader;
import org.apache.commons.lang3.NotImplementedException;
import org.rekex.helper.anno.Str;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    StringReader stringReader;

    public Tokenizer(StringReader stringReader) {
        this.stringReader = stringReader;
    }

    public static List<Token> tokenize(String string) {
        var tk = new Tokenizer(new StringReader(string));
        return tk.tokenize();
    }

    public List<Token> tokenize() {
        var tokens = new ArrayList<Token>();
        while(true) {
            Token token = parseSingleToken();
            if(token == null) {
                break;
            } else {
                tokens.add(token);
            }
        }
        return tokens;
    }

    public Token parseSingleToken() {
        if(this.stringReader.peek() == null) {
            return null;
        }

        this.stringReader.skipWhitespace();
        var rd = this.stringReader.read();
        return switch (rd) {
            case '+' -> new Token.Plus();
            case '-' -> new Token.Minus();
            case '*' -> new Token.Star();
            case '/' -> new Token.Slash();
            case '!' -> new Token.Exclamation();
            case ':' -> new Token.Colon();
            case '{' -> new Token.BracketOpen();
            case '}' -> new Token.BracketClose();
            case '(' -> new Token.OpenParen();
            case ')' -> new Token.CloseParen();
            case '>' -> new Token.GreaterThan();
            case '<' -> new Token.LessThan();
            case 'i' -> new Token.I();
            case '%' -> new Token.Percentage();
            case ',' -> new Token.Comma();
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                this.stringReader.backtrackBy(1);
                yield new Token.Number(parseNumber());
            }
            case 'r' -> {
                stringReader.expect(x -> x == 'r');
                yield new Token.Rr();
            }
            case 'd' -> {
                if(stringReader.peek() == 'r') {
                    stringReader.expect(x -> x == 'r');
                    stringReader.expect(x -> x == 'o');
                    stringReader.expect(x -> x == 'p');
                    yield new Token.Drop();
                }
                yield new Token.D();
            }
            default -> {
                throw new RuntimeException("Unexpected symbol: " + rd);
            }
        };
    }

    public double parseNumber() {
        StringBuilder num = new StringBuilder();
        while(this.stringReader.peek() != null && Character.isDigit(this.stringReader.peek())) {
            num.append(this.stringReader.read());
        }
        return Double.parseDouble(num.toString());
    }
}
