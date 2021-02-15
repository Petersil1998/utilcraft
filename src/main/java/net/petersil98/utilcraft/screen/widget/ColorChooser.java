package net.petersil98.utilcraft.screen.widget;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.petersil98.utilcraft.config.Config;

import javax.annotation.Nonnull;

import static java.lang.Math.*;

public class ColorChooser extends Widget {

    private int color;
    private final int radius;
    private final TextFieldWidget text;
    private final int textHeight;

    public ColorChooser(FontRenderer font, int x, int y, int width, int textHeight, ITextComponent title) {
        super(x, y, width, width, title);
        radius =  width/2;
        color = Config.DEATH_RAY_COLOR.get();
        text = new TextFieldWidget(font, x, y+width+10, width-textHeight-5, textHeight, new TranslationTextComponent("config.number_player_deaths"));
        text.setEnabled(false);
        this.textHeight = textHeight;
        updateColor();
    }

    @Override
    public void renderButton(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        if(visible) {
            for (int x = -radius; x < radius; x++) {
                for (int y = -radius; y < radius; y++) {
                    double distance = sqrt(x*x + y*y);

                    if (distance > radius) {
                        continue;
                    }

                    double angle = atan2(y, x);
                    double degrees = toDegrees(angle);

                    float hue = (float) (degrees < 0 ? 360 + degrees : degrees);
                    float saturation = (float) (distance/radius);

                    fill(matrixStack, x+radius+this.x, y+radius+this.y, x+radius+1+this.x, y+radius+1+this.y, hsv2rgb(hue, saturation, 1));
                }
            }
            text.renderButton(matrixStack, mouseX, mouseY, partialTicks);
            fill(matrixStack, x+width-textHeight-1, y+width+9, x+width, y+width+10+textHeight+1, 0xFF9E9E9E);
            fill(matrixStack, x+width-textHeight, y+width+10, x+width-1, y+width+10+textHeight, color);
        }
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        double distance = sqrt(pow(mouseX-x-radius, 2) + pow(mouseY-y-radius, 2));
        if(distance <= radius) {
            double angle = atan2(mouseY-y-radius, mouseX-x-radius);
            double degrees = toDegrees(angle);

            float hue = (float) (degrees < 0 ? 360 + degrees : degrees);
            float saturation = (float) (distance/radius);
            color = hsv2rgb(hue, saturation, 1);
            updateColor();
        }
    }

    private void updateColor() {
        text.setText(String.format("#%s", Integer.toHexString(color)).toUpperCase());
    }

    public int hsv2rgb(float hue, float saturation, float value) {
        float chroma = value * saturation;
        float hue1 = hue / 60;
        float x = chroma * (1- Math.abs((hue1 % 2) - 1));
        float r1 = 0, g1 = 0, b1 = 0;
        if (hue1 >= 0 && hue1 <= 1) {
            r1 = chroma;
            g1 = x;
            b1 = 0;
        } else if (hue1 >= 1 && hue1 <= 2) {
            r1 = x;
            g1 = chroma;
            b1 = 0;
        } else if (hue1 >= 2 && hue1 <= 3) {
            r1 = 0;
            g1 = chroma;
            b1 = x;
        } else if (hue1 >= 3 && hue1 <= 4) {
            r1 = 0;
            g1 = x;
            b1 = chroma;
        } else if (hue1 >= 4 && hue1 <= 5) {
            r1 = x;
            g1 = 0;
            b1 = chroma;
        } else if (hue1 >= 5 && hue1 <= 6) {
            r1 = chroma;
            g1 = 0;
            b1 = x;
        }

        float m = value - chroma;
        float r = r1+m, g = g1+m, b = b1+m;

        return (0xff << 24) | (((int)(255*r) & 0xff) << 16) | (((int)(255*g) & 0xff) << 8) | ((int)(255*b) & 0xff);
    }

    public int getColor() {
        return color;
    }
}
