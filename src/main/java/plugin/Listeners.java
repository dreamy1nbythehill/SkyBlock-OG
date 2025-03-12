package plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class Listeners implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onBlockBreak(BlockBreakEvent event) {

        //CompletableFuture<PostgreSQL.PlayerBalance> asyncPlayerBalance = DiamondBankOG.getApi().getPlayerBalance(event.getPlayer().getUniqueId(), PostgreSQL.BalanceType.ALL);

        //try {

        //PostgreSQL.PlayerBalance balanceResult = asyncPlayerBalance.get();

        //double totalBalance = balanceResult.getBankBalance() + balanceResult.getEnderChestBalance() + balanceResult.getInventoryBalance();

        // Send a message to the player with their balance.

  //      UtilitiesOG.trueogMessage(event.getPlayer(), "&BYour balance is: &e" + 5 + "&B Diamonds.");

   //     UtilitiesOG.logToConsole("[Template-OG]", "The player: " + event.getPlayer() + "'s <aqua>balance</aqua> is: " + 5 + "&B Diamonds");


        //}
        //catch (InterruptedException | ExecutionException error) {

        //	UtilitiesOG.logToConsole(TemplateOG.getPlugin(), "ERROR: The player: " + event.getPlayer() + "'s balance could not be fetched! ERROR: " + error.getMessage());

        //}

    }

}