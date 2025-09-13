package dev.infernity.rollplayer.listeners.debug;

import dev.infernity.rollplayer.listeners.templates.SimpleCommandListener;
import dev.infernity.rollplayer.rollplayerlib3.reader.StringReader;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class DebugCommand extends SimpleCommandListener {
    public DebugCommand() {
        super("debug", "debug desc", "\uD83D\uDD27");
    }

    public void onCommandRan(@NotNull SlashCommandInteractionEvent event) {
        var reader = new StringReader("1234");
        event.replyComponents(createContainer(
                TextDisplay.of(String.valueOf(reader.read()) + reader.read() + reader.peek() + reader.peek()))
        ).useComponentsV2().queue();
    }
}
