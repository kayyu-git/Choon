package mod.kayyugit.chungus;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Chungus.MODID)
public final class Chungus
{
	public static final String MODID = "chungus";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public Chungus()
	{
		LOGGER.debug("Hello from Chungus!");
	}
	
}
