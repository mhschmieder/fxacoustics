/**
 * MIT License
 *
 * Copyright (c) 2020, 2025 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the FxAcousticsGui Library
 *
 * You should have received a copy of the MIT License along with the
 * FxAcousticsGui Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxacousticsgui
 */
package com.mhschmieder.fxacousticsgui.action;

import java.util.Collection;

import org.controlsfx.control.action.Action;

import com.mhschmieder.commonstoolkit.util.ClientProperties;
import com.mhschmieder.fxguitoolkit.action.ActionFactory;
import com.mhschmieder.fxguitoolkit.action.XAction;
import com.mhschmieder.fxguitoolkit.action.XActionGroup;

/**
 * This is a utility class for making labeled actions for Acoustics.
 * <p>
 * TODO: Move the icons into the resources folder and reference correctly.
 */
public class AcousticsLabeledActionFactory {

    // NOTE: We must substitute "." for resource directory tree delimiters.
    @SuppressWarnings("nls") public static final String BUNDLE_NAME =
                                                                    "properties.AcousticsActionLabels";

    /**
     * The default constructor is disabled, as this is a static factory class.
     */
    private AcousticsLabeledActionFactory() {}

    @SuppressWarnings("nls")
    public static XActionGroup getSplPaletteChoiceGroup( final ClientProperties clientProperties,
                                                         final SplPaletteChoices splPaletteChoices ) {
        final Collection< Action > splPaletteChoiceCollection = splPaletteChoices
                .getSplPaletteChoiceCollection();

        final XActionGroup splPaletteChoiceGroup = ActionFactory
                .makeChoiceGroup( clientProperties,
                                  splPaletteChoiceCollection,
                                  BUNDLE_NAME,
                                  "splPalette",
                                  "/icons/led24/Palette16.png" );

        return splPaletteChoiceGroup;
    }

    @SuppressWarnings("nls")
    public static XAction getSplPaletteColor1dbChoice( final ClientProperties clientProperties ) {
        return ActionFactory
                .makeChoice( clientProperties, BUNDLE_NAME, "splPalette", "color1db", null, true );
    }

    @SuppressWarnings("nls")
    public static XAction getSplPaletteColor2dbChoice( final ClientProperties clientProperties ) {
        return ActionFactory
                .makeChoice( clientProperties, BUNDLE_NAME, "splPalette", "color2db", null, true );
    }

    @SuppressWarnings("nls")
    public static XAction getSplPaletteColor3dbChoice( final ClientProperties clientProperties ) {
        return ActionFactory
                .makeChoice( clientProperties, BUNDLE_NAME, "splPalette", "color3db", null, true );
    }

    @SuppressWarnings("nls")
    public static XAction getSplPaletteColors256Choice( final ClientProperties clientProperties ) {
        return ActionFactory.makeChoice( clientProperties, 
                                         BUNDLE_NAME, 
                                         "splPalette", 
                                         "colors256", 
                                         "/icons/ahaSoft/256Colors16.png", 
                                         true );
    }

    @SuppressWarnings("nls")
    public static XAction getSplPaletteColors64Choice( final ClientProperties clientProperties ) {
        return ActionFactory.makeChoice( clientProperties,
                                         BUNDLE_NAME, 
                                         "splPalette", 
                                         "colors64", 
                                         "/icons/ahaSoft/16Colors16.png", 
                                         true );
    }

    @SuppressWarnings("nls")
    public static XAction getSettingsSplRangeAction( final ClientProperties clientProperties ) {
        return ActionFactory.makeAction( clientProperties,
                                         BUNDLE_NAME,
                                         "settings",
                                         "splRange",
                                         "/icons/mhschmieder/SplRange16.png" );
    }

    @SuppressWarnings("nls")
    public static XAction getTestDitheringAmountAction( final ClientProperties clientProperties ) {
        return ActionFactory.makeAction( clientProperties,
                                         BUNDLE_NAME,
                                         "test",
                                         "ditheringAmount",
                                         "/icons/yusukeKamiyamane/fugue/ImageBlur16.png" );
    }

    @SuppressWarnings("nls")
    public static XAction getSmoothingChoice( final ClientProperties clientProperties,
                                              final String itemName ) {
        return ActionFactory
                .makeChoice( clientProperties, BUNDLE_NAME, "smoothing", itemName, null, true );
    }

    @SuppressWarnings("nls")
    public static XAction getSmoothingNarrowChoice( final ClientProperties clientProperties ) {
        return getSmoothingChoice( clientProperties, "narrow" );
    }

    @SuppressWarnings("nls")
    public static XAction getSmoothingSixthOctaveChoice( final ClientProperties clientProperties ) {
        return getSmoothingChoice( clientProperties, "sixthOctave" );
    }

    @SuppressWarnings("nls")
    public static XAction getSmoothingThirdOctaveChoice( final ClientProperties clientProperties ) {
        return getSmoothingChoice( clientProperties, "thirdOctave" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv1DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div1db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv2DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div2db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv3DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div3db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv6DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div6db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv10DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div10db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv12DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div12db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv15DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div15db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv20DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div20db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDiv30DbChoice( final ClientProperties clientProperties ) {
        return getDivChoice( clientProperties, "div30db" );
    }

    @SuppressWarnings("nls")
    public static XAction getDivChoice( final ClientProperties clientProperties,
                                        final String itemName ) {
        return ActionFactory
                .makeChoice( clientProperties, BUNDLE_NAME, "verticalZoom", itemName, null, true );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom1120msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "1120ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom112msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "112ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom140msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "140ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom14msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "14ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom280msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "280ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom28msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "28ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom560msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "560ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom56msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "56ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom70msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "70ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoom7msChoice( final ClientProperties clientProperties ) {
        return getHorizontalZoomChoice( clientProperties, "7ms" );
    }

    @SuppressWarnings("nls")
    public static XAction getHorizontalZoomChoice( final ClientProperties clientProperties,
                                                   final String itemName ) {
        return ActionFactory
                .makeChoice( clientProperties, BUNDLE_NAME, "horizontalZoom", itemName, null, true );
    }

    @SuppressWarnings("nls")
    public static XAction getZoomFullFrequencyRangeChoice( final ClientProperties clientProperties ) {
        return ActionFactory.makeChoice( clientProperties,
                                         BUNDLE_NAME,
                                         "horizontalZoom",
                                         "fullFrequencyRange",
                                         null,
                                         true );
    }

    @SuppressWarnings("nls")
    public static XAction getZoomHighFrequencyRangeChoice( final ClientProperties clientProperties ) {
        return ActionFactory.makeChoice( clientProperties,
                                         BUNDLE_NAME,
                                         "horizontalZoom",
                                         "highFrequency",
                                         null,
                                         true );
    }

    @SuppressWarnings("nls")
    public static XAction getZoomLowFrequencyRangeChoice( final ClientProperties clientProperties ) {
        return ActionFactory.makeChoice( clientProperties,
                                         BUNDLE_NAME,
                                         "horizontalZoom",
                                         "lowFrequency",
                                         null,
                                         true );
    }

    @SuppressWarnings("nls")
    public static XAction getZoomLowMidFrequencyRangeChoice( final ClientProperties clientProperties ) {
        return ActionFactory.makeChoice( clientProperties,
                                         BUNDLE_NAME,
                                         "horizontalZoom",
                                         "lowMidFrequency",
                                         null,
                                         true );
    }

    @SuppressWarnings("nls")
    public static XAction getZoomMidFrequencyRangeChoice( final ClientProperties clientProperties ) {
        return ActionFactory.makeChoice( clientProperties,
                                         BUNDLE_NAME,
                                         "horizontalZoom",
                                         "midFrequency",
                                         null,
                                         true );
    }

    @SuppressWarnings("nls")
    public static XAction getZoomMidHighFrequencyRangeChoice( final ClientProperties clientProperties ) {
        return ActionFactory.makeChoice( clientProperties,
                                         BUNDLE_NAME,
                                         "horizontalZoom",
                                         "midHighFrequency",
                                         null,
                                         true );
    }
}
