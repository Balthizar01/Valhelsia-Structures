package com.stal111.valhelsia_structures.init;

import com.stal111.valhelsia_structures.ValhelsiaStructures;
import com.stal111.valhelsia_structures.world.structures.SmallCastlePieces;
import com.stal111.valhelsia_structures.world.structures.TowerRuinPieces;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

/**
 * ValhelsiaStructure Structure Pieces
 * ValhelsiaStructure - com.stal111.valhelsia_structure.init.ModStructurePieces
 *
 * @author Valhelsia Team
 * @version 0.1
 * @since 2019-10-31
 */
public class ModStructurePieces {
    // Structure Pieces
    public static final IStructurePieceType SMALL_CASTLE = register("small_castle", SmallCastlePieces.SmallCastlePiece::new);
    public static final IStructurePieceType TOWER_RUIN = register("tower_ruin", TowerRuinPieces.Piece::new);

    private static IStructurePieceType register(String key, IStructurePieceType type) {
        return Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(ValhelsiaStructures.MOD_ID, key), type);
    }
}
