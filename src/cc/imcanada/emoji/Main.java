package cc.imcanada.emoji;
 
import org.bukkit.command.Command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public final class Main extends JavaPlugin implements Listener{
	String Prefix = ChatColor.GOLD+""+ChatColor.BOLD+"Emojicore "+ChatColor.DARK_GRAY+"» ";
	
	public void onEnable() {
		getLogger().info("EmojiCore has been enabled.");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		getLogger().info("EmojiCore has been disabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("emojis")) { 
			sender.sendMessage(Prefix+ChatColor.YELLOW+"List of available emojis:"
					+ "\n- :star: - Star emoji ★"
					+ "\n- :heart: - Heart emoji ♥"
					+ "\n- :shrug: - Shrugging emoji ¯\\_(ツ)_/¯");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("emojicore")) { 
			sender.sendMessage(Prefix+ChatColor.YELLOW+"EmojiCore version 1.0.0, do /emojis for a list of emojis.\nUpdate URL: "+ChatColor.AQUA+"https://github.com/imcanada/emojicore/releases");
			return true;
		} 
		return false; 
	}
	
    @EventHandler(priority=EventPriority.HIGHEST)
    public void Heart(AsyncPlayerChatEvent event)
    {
    	Player player = event.getPlayer();
    	
    	String message = event.getMessage();
    	if (message.contains(":heart:")) {
    		if(player.hasPermission("emojicore.use.heart")){
                message = message.replace(":heart:", "♥");
               
                event.setMessage(message);
        	}
        	else if(player.hasPermission("emojicore.use.*")){
                message = message.replace(":heart:", "♥");
               
                event.setMessage(message);
        	}
        	else {
            	player.sendMessage(Prefix+ChatColor.YELLOW+"You do not have permission to use this emoji.");
        	}
    	}
    	else if (message.contains(":star:")) {
    		if(player.hasPermission("emojicore.use.star")){
                message = message.replace(":star:", "✩");
               
                event.setMessage(message);
        	}
        	else if(player.hasPermission("emojicore.use.*")){
                message = message.replace(":star:", "✩");
               
                event.setMessage(message);
        	}
        	else {
        		player.sendMessage(Prefix+ChatColor.YELLOW+"You do not have permission to use this emoji.");
        	}
    	}
    	else if (message.contains(":shrug:")) {
    		if(player.hasPermission("emojicore.use.shrug")){
                message = message.replace(":shrug:", "¯\\_(ツ)_/¯");
               
                event.setMessage(message);
        	}
        	else if(player.hasPermission("emojicore.use.*")){
                message = message.replace(":shrug:", "¯\\_(ツ)_/¯");
               
                event.setMessage(message);
        	}
        	else {
        		player.sendMessage(Prefix+ChatColor.YELLOW+"You do not have permission to use this emoji.");
        	}
    	}
    }
}