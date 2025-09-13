package dev.infernity.rollplayer.rollplayerlib3.reader;

public interface Reader<T, E> {
    E read();
    E peek();
    T getSource();
    int index();
}
