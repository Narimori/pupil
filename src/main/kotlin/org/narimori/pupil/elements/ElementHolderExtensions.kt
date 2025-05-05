package org.narimori.pupil.elements

import eu.pb4.polymer.virtualentity.api.ElementHolder
import eu.pb4.polymer.virtualentity.api.elements.*
import net.minecraft.block.BlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text

public val ElementHolder.abstractElements: List<AbstractElement> get() = elements()

public val ElementHolder.blockDisplayElements: List<BlockDisplayElement> get() = elements()

public val ElementHolder.displayElements: List<DisplayElement> get() = elements()

public val ElementHolder.entityElements: List<EntityElement<*>> get() = elements()

public val ElementHolder.genericEntityElements: List<GenericEntityElement> get() = elements()

public val ElementHolder.interactionElements: List<InteractionElement> get() = elements()

public val ElementHolder.itemDisplayElements: List<ItemDisplayElement> get() = elements()

public val ElementHolder.markerElements: List<MarkerElement> get() = elements()

public val ElementHolder.mobAnchorElements: List<MobAnchorElement> get() = elements()

public val ElementHolder.simpleEntityElements: List<SimpleEntityElement> get() = elements()

public val ElementHolder.textDisplayElements: List<TextDisplayElement> get() = elements()

public val ElementHolder.virtualElements: List<VirtualElement> get() = elements()

public inline fun elementHolder(block: ElementHolder.() -> Unit): ElementHolder = ElementHolder().apply(block)

public inline fun ElementHolder.abstractElements(block: AbstractElement.() -> Unit) = elements(block)

public inline fun ElementHolder.blockDisplayElements(block: BlockDisplayElement.() -> Unit) = elements(block)

public inline fun ElementHolder.blockDisplayElement(block: BlockDisplayElement.() -> Unit): BlockDisplayElement =
    addElement(org.narimori.pupil.elements.blockDisplayElement(block))

public inline fun ElementHolder.blockDisplayElement(
    state: BlockState,
    block: BlockDisplayElement.() -> Unit
): BlockDisplayElement = addElement(org.narimori.pupil.elements.blockDisplayElement(state, block))

public inline fun ElementHolder.displayElements(block: DisplayElement.() -> Unit) = elements(block)

public inline fun ElementHolder.entityElements(block: EntityElement<*>.() -> Unit) = elements(block)

public inline fun <T : Entity> ElementHolder.entityElement(
    entity: T,
    world: ServerWorld,
    block: EntityElement<T>.() -> Unit
): EntityElement<T> = addElement(org.narimori.pupil.elements.entityElement(entity, world, block))

public inline fun <T : Entity> ElementHolder.entityElement(
    entity: T,
    world: ServerWorld,
    handler: VirtualElement.InteractionHandler,
    block: EntityElement<T>.() -> Unit
): EntityElement<T> = addElement(org.narimori.pupil.elements.entityElement(entity, world, handler, block))

public inline fun <T : Entity> ElementHolder.entityElement(
    type: EntityType<T>,
    world: ServerWorld,
    block: EntityElement<T>.() -> Unit
): EntityElement<T> = addElement(org.narimori.pupil.elements.entityElement(type, world, block))

public inline fun <T : Entity> ElementHolder.entityElement(
    type: EntityType<T>,
    world: ServerWorld,
    handler: VirtualElement.InteractionHandler,
    block: EntityElement<T>.() -> Unit
): EntityElement<T> = addElement(org.narimori.pupil.elements.entityElement(type, world, handler, block))

public inline fun ElementHolder.genericEntityElements(block: GenericEntityElement.() -> Unit) = elements(block)

public inline fun ElementHolder.interactionElements(block: InteractionElement.() -> Unit) = elements(block)

public inline fun ElementHolder.interactionElement(block: InteractionElement.() -> Unit): InteractionElement =
    addElement(org.narimori.pupil.elements.interactionElement(block))

public inline fun ElementHolder.interactionElement(
    handler: VirtualElement.InteractionHandler,
    block: InteractionElement.() -> Unit
): InteractionElement = addElement(org.narimori.pupil.elements.interactionElement(handler, block))

public inline fun ElementHolder.interactionElement(
    redirect: Entity,
    block: InteractionElement.() -> Unit
): InteractionElement = addElement(org.narimori.pupil.elements.interactionElement(redirect, block))

public inline fun ElementHolder.itemDisplayElements(block: ItemDisplayElement.() -> Unit) = elements(block)

public inline fun ElementHolder.itemDisplayElement(block: ItemDisplayElement.() -> Unit): ItemDisplayElement =
    addElement(org.narimori.pupil.elements.itemDisplayElement(block))

public inline fun ElementHolder.itemDisplayElement(
    stack: ItemStack,
    block: ItemDisplayElement.() -> Unit
): ItemDisplayElement = addElement(org.narimori.pupil.elements.itemDisplayElement(stack, block))

public inline fun ElementHolder.itemDisplayElement(
    item: Item,
    block: ItemDisplayElement.() -> Unit
): ItemDisplayElement = addElement(org.narimori.pupil.elements.itemDisplayElement(item, block))

public inline fun ElementHolder.markerElements(block: MarkerElement.() -> Unit) = elements(block)

public inline fun ElementHolder.markerElement(block: MarkerElement.() -> Unit): MarkerElement =
    addElement(org.narimori.pupil.elements.markerElement(block))

public inline fun ElementHolder.mobAnchorElements(block: MobAnchorElement.() -> Unit) = elements(block)

public inline fun ElementHolder.mobAnchorElement(block: MobAnchorElement.() -> Unit): MobAnchorElement =
    addElement(org.narimori.pupil.elements.mobAnchorElement(block))

public inline fun ElementHolder.simpleEntityElements(block: SimpleEntityElement.() -> Unit) = elements(block)

public inline fun ElementHolder.simpleEntityElement(
    type: EntityType<*>,
    block: SimpleEntityElement.() -> Unit
): SimpleEntityElement = addElement(org.narimori.pupil.elements.simpleEntityElement(type, block))

public inline fun ElementHolder.textDisplayElements(block: TextDisplayElement.() -> Unit) = elements(block)

public inline fun ElementHolder.textDisplayElement(block: TextDisplayElement.() -> Unit): TextDisplayElement =
    addElement(org.narimori.pupil.elements.textDisplayElement(block))

public inline fun ElementHolder.textDisplayElement(
    text: Text,
    block: TextDisplayElement.() -> Unit
): TextDisplayElement = addElement(org.narimori.pupil.elements.textDisplayElement(text, block))

public inline fun ElementHolder.virtualElements(block: VirtualElement.() -> Unit) = elements(block)

public inline fun <reified T : VirtualElement> ElementHolder.elements(): List<T> = elements.filterIsInstance<T>()

public inline fun <reified T : VirtualElement> ElementHolder.elements(block: T.() -> Unit) =
    elements<T>().forEach(block)