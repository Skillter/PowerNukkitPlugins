package upodev;

import cn.nukkit.Nukkit;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.Listener;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.window.FormWindowModal;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

import java.util.Objects;


public class Main extends PluginBase {

    public static boolean isEnabled;
    public static boolean isActive = true;

    public static Plugin instance = null;

    public void onEnable() {
        instance = this;
        initConfig();
        this.getServer().getPluginManager().registerEvents((Listener)new EventListener(), this);

    }

    public void onDisable() {
        instance = null;
    }

    public void initConfig() {
        this.saveDefaultConfig();
        this.isEnabled = this.getConfig().getBoolean("enabled");
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("powernukkitplugin.command")) {
            if (Objects.equals(command.getName(), "powernukkitplugin")) {
                if (args.length == 0) {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage(TextFormat.RED + "Please use this command in-game");
                        return true;
                    }
                    if (isEnabled) {
                        if (isActive) {
                            isActive = false;
                            sender.sendMessage(this.getConfig().getString("disableMessage"));
                        } else {
                            isActive = true;
                            sender.sendMessage(this.getConfig().getString("enableMessage"));
                        }
                        return true;
                    }
                    sender.sendMessage(this.getConfig().getString("keepExperienceDisabled"));
                } else if (args.length >= 1) {
                    if (args[0].equalsIgnoreCase("gui")) {
                        sender.sendMessage("test");
                        ((Player)sender).showFormWindow(new FormWindowModal("Tips", "Hello", "Yes", "No"));
                    }
                }

            }
        }
        return true;
    }

}