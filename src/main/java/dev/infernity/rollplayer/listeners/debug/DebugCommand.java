package dev.infernity.rollplayer.listeners.debug;

import dev.infernity.rollplayer.listeners.templates.SimpleCommandListener;
import dev.infernity.rollplayer.rollplayerlib3.parser.Tokenizer;
import net.dv8tion.jda.api.components.textdisplay.TextDisplay;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DebugCommand extends SimpleCommandListener {
    public DebugCommand() {
        super("debug", "debug desc", "\uD83D\uDD27");
    }

    @Override
    public List<CommandData> getCommandData(){
        return List.of(
                Commands.slash(commandName, commandDescription)
                        .addOption(OptionType.STRING, "text", "text", true)
        );
    }

    public void onCommandRan(@NotNull SlashCommandInteractionEvent event) {
        var text = event.getOption("text", OptionMapping::getAsString);
        event.replyComponents(createContainer(TextDisplay.of(Tokenizer.tokenize(text).toString()))).useComponentsV2().queue();
    }
}
