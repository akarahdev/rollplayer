package dev.infernity.rollplayer.rollplayerlib3.parser;

public interface Token {
    record EOF() implements Token {}

    record Number(double value) implements Token {}

    record Plus() implements Token {}
    record D() implements Token {}
    record Minus() implements Token {}
    record Star() implements Token {}
    record Slash() implements Token {}
    record BracketOpen() implements Token {}
    record BracketClose() implements Token {}
    record OpenParen() implements Token {}
    record CloseParen() implements Token {}
    record Kh() implements Token {}
    record Kl() implements Token {}
    record Exclamation() implements Token {}
    record Colon() implements Token {}
    record GreaterThan() implements Token {}
    record LessThan() implements Token {}
    record Drop() implements Token {}
    record Rr() implements Token {}
    record I() implements Token {}
    record Percentage() implements Token {}
    record Comma() implements Token {}
}
