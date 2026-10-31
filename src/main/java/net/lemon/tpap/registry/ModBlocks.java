package net.lemon.tpap.registry;

import net.lemon.tpap.TPAP;
import net.lemon.tpap.block.SculptorsStationBlock;
import net.lemon.tpap.block.StatueBlock;
import net.lemon.tpap.item.MoldSize;
import net.lemon.tpap.item.SculptorsStationItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TPAP.MODID);

    /** All registered statues. Drives the shared BE type's valid blocks and the creative tab. */
    public static final List<RegistryObject<StatueBlock>> STATUES = new ArrayList<>();
    public static final List<RegistryObject<Item>> STATUE_ITEMS = new ArrayList<>();
    public static final Map<String, List<StatueEntry>> GENUS_MAP = new LinkedHashMap<>();

    public record StatueEntry(String statueId, String genus, MoldSize moldSize,
                              RegistryObject<StatueBlock> block, RegistryObject<Item> item) {
    }

    //Add Statues below: registerStatue(statueId, genus, poseCount, proppable, moldSize)
    public static final RegistryObject<StatueBlock> TRICERATOPS_HORRIDUS = registerStatue("triceratops_horridus", "triceratops", 5, false, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> TARBOSAURUS_BATAAR = registerStatue("tarbosaurus_bataar", "tarbosaurus", 10, true, MoldSize.HUGE);
    public static final RegistryObject<StatueBlock> MARASUCHUS_LILLOENSIS = registerStatue("marasuchus_lilloensis", "marasuchus", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> BARINASUCHUS_ARVELOI = registerStatue("barinasuchus_arveloi", "barinasuchus", 5, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> PACHYRHINOSAURUS_CANADENSIS = registerStatue("pachyrhinosaurus_canadensis", "pachyrhinosaurus", 5, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> DESMODUS_DRACULAE = registerStatue("desmodus_draculae", "desmodus", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> ASILISAURUS_KONGWE = registerStatue("asilisaurus_kongwe", "asilisaurus", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> KARPINSKIPRION_IVANOVI = registerStatue("karpinskiprion_ivanovi", "karpinskiprion", 5, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> PARADICEROS_MUKIRII = registerStatue("paradiceros_mukirii", "paradiceros", 5, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> LIVYATAN_MELVILLEI = registerStatue("livyatan_melvillei", "livyatan", 6, true, MoldSize.HUGE);
    public static final RegistryObject<StatueBlock> MEGALONYX_JEFFERSONII = registerStatue("megalonyx_jeffersonii", "megalonyx", 7, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> SECODONTOSAURUS_OBTUSIDENS = registerStatue("secodontosaurus_obtusidens", "secodontosaurus", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> APTERODON_MACROGNATHUS = registerStatue("apterodon_macrognathus", "apterodon", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> ISISAURUS_COLBERTI = registerStatue("isisaurus_colberti", "isisaurus", 5, true, MoldSize.HUGE);
    public static final RegistryObject<StatueBlock> ENDOCERAS_GIGANTEUM = registerStatue("endoceras_giganteum", "endoceras", 5, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> PAKICETUS_INACHUS = registerStatue("pakicetus_inachus", "pakicetus", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> RAPHUS_CUCULLATUS = registerStatue("raphus_cucullatus", "raphus", 6, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> IRRITATOR_CHALLENGERI = registerStatue("irritator_challengeri", "irritator", 5, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> PROTEOTHRINAX_LUDVIGSENI = registerStatue("proteothrinax_ludvigseni", "proteothrinax", 5, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> CAUCASOCHASMA_ZHERIKHINI = registerStatue("caucasochasma_zherikhini", "caucasochasma", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> STUPENDEMYS_GEOGRAPHICUS_MALE = registerStatue("stupendemys_geographicus_male", "stupendemys", 7, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> STUPENDEMYS_GEOGRAPHICUS_FEMALE = registerStatue("stupendemys_geographicus_female", "stupendemys", 7, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> PTYCHODUS_LATISSIMUS = registerStatue("ptychodus_latissimus", "ptychodus", 5, true, MoldSize.HUGE);
    public static final RegistryObject<StatueBlock> IVOITES_SCHINDEWOLFI = registerStatue("ivoites_schindewolfi", "ivoites", 3, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> ORTHACANTHUS_TEXENSIS = registerStatue("orthacanthus_texensis", "orthacanthus", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> SMILODON_FATALIS = registerStatue("smilodon_fatalis", "smilodon", 11, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> LISOWICIA_BOJANI = registerStatue("lisowicia_bojani", "lisowicia", 8, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> TROPITES_SUBBULLATUS = registerStatue("tropites_subbullatus", "tropites", 4, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> SACHICASAURUS_VITAE = registerStatue("sachicasaurus_vitae", "sachicasaurus", 8, true, MoldSize.HUGE);
    public static final RegistryObject<StatueBlock> CERATOSAURUS_DENTISULCATUS = registerStatue("ceratosaurus_dentisulcatus", "ceratosaurus", 9, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> MONONYKUS_OLECRANUS = registerStatue("mononykus_olecranus", "mononykus", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> PULMONOSCORPIUS_KIRKTONENSIS = registerStatue("pulmonoscorpius_kirktonensis", "pulmonoscorpius", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> DIMETRODON_GRANDIS = registerStatue("dimetrodon_grandis", "dimetrodon", 7, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> DUNKLEOSTEUS_TERRELLI = registerStatue("dunkleosteus_terrelli", "dunkleosteus", 6, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> HOMOSTEUS_FORMOSISSIMUS = registerStatue("homosteus_formosissimus", "homosteus", 5, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> CHERNINIA_DENWAI = registerStatue("cherninia_denwai", "cherninia", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> AMBULOCETUS_NATANS = registerStatue("ambulocetus_natans", "ambulocetus", 5, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> DACTYLIOCERAS_COMMUNE = registerStatue("dactylioceras_commune", "dactylioceras", 4, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> ALLODESMUS_DEMEREI = registerStatue("allodesmus_demerei", "allodesmus", 7, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> GIRAFFA_JUMAE = registerStatue("giraffa_jumae", "giraffa", 5, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> CERVALCES_SCOTTI = registerStatue("cervalces_scotti", "cervalces", 6, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> INOSTRANCEVIA_ALEXANDRI = registerStatue("inostrancevia_alexandri", "inostrancevia", 6, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> MEGANEURA_MONYI = registerStatue("meganeura_monyi", "meganeura", 6, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> ALIERASAURUS_RONCHII = registerStatue("alierasaurus_ronchii", "alierasaurus", 6, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> PHOLIDERPETON_ATTHEYI = registerStatue("pholiderpeton_attheyi", "pholiderpeton", 8, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> TULLIMONSTRUM_GREGARIUM = registerStatue("tullimonstrum_gregarium", "tullimonstrum", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> HIPPOPOTAMUS_GORGOPS = registerStatue("hippopotamus_gorgops", "hippopotamus", 7, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> PROTELES_SEPTENTRIONALIS = registerStatue("proteles_septentrionalis", "proteles", 13, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> EOREDLICHIA_INTERMEDIA = registerStatue("eoredlichia_intermedia", "eoredlichia", 6, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> MEGALODON_SP = registerStatue("megalodon_sp", "megalodon", 4, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> CANADASPIS_PERFECTA = registerStatue("canadaspis_perfecta", "canadaspis", 4, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> INDOHYUS_INDIRAE = registerStatue("indohyus_indirae", "indohyus", 5, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> BISON_LATIFRONS = registerStatue("bison_latifrons", "bison", 7, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> TAPIRUS_CALIFORNICUS = registerStatue("tapirus_californicus", "tapirus", 6, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> RAJASAURUS_NARMADENSIS = registerStatue("rajasaurus_narmadensis", "rajasaurus", 8, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> KARIRIDRACO_DIANAE = registerStatue("kariridraco_dianae", "kariridraco", 7, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> QUETZALCOATLUS_NORTHROPI = registerStatue("quetzalcoatlus_northropi", "quetzalcoatlus", 14, true, MoldSize.HUGE);
    public static final RegistryObject<StatueBlock> POSTOSUCHUS_KIRKPATRICKI = registerStatue("postosuchus_kirkpatricki", "postosuchus", 6, true, MoldSize.SMALL);
    public static final RegistryObject<StatueBlock> ETJOSUCHUS_RECURVIDENS = registerStatue("etjosuchus_recurvidens", "etjosuchus", 5, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> APATOSAURUS_LOUISAE = registerStatue("apatosaurus_louisae", "apatosaurus", 19, true, MoldSize.HUGE);
    public static final RegistryObject<StatueBlock> STEGOSAURUS_STENOPS = registerStatue("stegosaurus_stenops", "stegosaurus", 18, true, MoldSize.LARGE);
    public static final RegistryObject<StatueBlock> CONCAVENATOR_CORCOVATUS = registerStatue("concavenator_corcovatus", "concavenator", 24, true, MoldSize.MEDIUM);
    public static final RegistryObject<StatueBlock> JONKERIA_TRUCULENTA = registerStatue("jonkeria_truculenta", "jonkeria", 9, true, MoldSize.LARGE);






    public static final RegistryObject<SculptorsStationBlock> SCULPTORS_STATION = BLOCKS.register("sculptors_station",
            () -> new SculptorsStationBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(2.5F).noOcclusion()));

    private static RegistryObject<StatueBlock> registerStatue(String statueId, String genus, int poseCount,
                                                              boolean proppable, MoldSize moldSize) {
        RegistryObject<StatueBlock> block = BLOCKS.register(statueId,
                () -> new StatueBlock(statueId, genus, poseCount, proppable, BlockBehaviour.Properties.of()
                        .mapColor(MapColor.STONE)
                        .sound(SoundType.STONE)
                        .strength(1.5F, 6.0F)
                        .noOcclusion()
                        .noCollission()
                ));

        RegistryObject<Item> item = ModItems.ITEMS.register(statueId, () -> new BlockItem(block.get(), new Item.Properties()));
        STATUES.add(block);
        STATUE_ITEMS.add(item);
        GENUS_MAP.computeIfAbsent(genus, g -> new ArrayList<>())
                .add(new StatueEntry(statueId, genus, moldSize, block, item));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}