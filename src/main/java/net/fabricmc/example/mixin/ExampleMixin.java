package net.fabricmc.example.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class ExampleMixin {
	@Inject(at = @At(value = "INVOKE", target = "Ljava/lang/Runtime;maxMemory()J"), method = "render(FZII)V")
	private void render(float tickDelta, boolean screenOpen, int mouseX, int mouseY, CallbackInfo info) {
		TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
		textRenderer.drawWithShadow("wow, crabs bad!", 2, 52, 0xFFFFFF);
	}
}
