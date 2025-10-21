/*
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
 * This file is part of the FxAcoustics Library
 *
 * You should have received a copy of the MIT License along with the FxAcoustics
 * Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/fxacoustics
 */
package com.mhschmieder.fxacoustics.action;

import com.mhschmieder.fxguitoolkit.action.XAction;
import com.mhschmieder.jacoustics.SplPaletteResolution;
import com.mhschmieder.jcommons.util.ClientProperties;
import org.controlsfx.control.action.Action;

import java.util.Arrays;
import java.util.Collection;

/**
 * This is a struct-like container for generic SPL Palette choices, generally
 * referring to the granularity or resolution of visualizations that map values
 * to a color range, and allowing for choices based on the number of colors or
 * based on the divisions per decibel range.
 */
public final class SplPaletteChoices {

    // Declare all of the SPL Palette choices.
    public XAction _splPaletteColors256Choice;
    public XAction _splPaletteColors64Choice;
    public XAction _splPaletteColor1dbChoice;
    public XAction _splPaletteColor2dbChoice;
    public XAction _splPaletteColor3dbChoice;

    // Default constructor
    public SplPaletteChoices( final ClientProperties clientProperties ) {
        _splPaletteColors256Choice = AcousticsLabeledActionFactory
                .getSplPaletteColors256Choice( clientProperties );
        _splPaletteColors64Choice = AcousticsLabeledActionFactory
                .getSplPaletteColors64Choice( clientProperties );
        _splPaletteColor1dbChoice = AcousticsLabeledActionFactory
                .getSplPaletteColor1dbChoice( clientProperties );
        _splPaletteColor2dbChoice = AcousticsLabeledActionFactory
                .getSplPaletteColor2dbChoice( clientProperties );
        _splPaletteColor3dbChoice = AcousticsLabeledActionFactory
                .getSplPaletteColor3dbChoice( clientProperties );
    }

    public Collection< Action > getSplPaletteChoiceCollection() {
        final Collection< Action > splPaletteChoiceCollection = Arrays
                .asList( _splPaletteColors256Choice,
                         _splPaletteColors64Choice,
                         _splPaletteColor1dbChoice,
                         _splPaletteColor2dbChoice,
                         _splPaletteColor3dbChoice );
        return splPaletteChoiceCollection;
    }

    public void setSplPaletteResolution( final SplPaletteResolution splPaletteResolution ) {
        switch ( splPaletteResolution ) {
        case RES_256:
            _splPaletteColors256Choice.setSelected( true );
            break;
        case RES_64:
            _splPaletteColors64Choice.setSelected( true );
            break;
        case RES_1DB:
            _splPaletteColor1dbChoice.setSelected( true );
            break;
        case RES_2DB:
            _splPaletteColor2dbChoice.setSelected( true );
            break;
        case RES_3DB:
            _splPaletteColor3dbChoice.setSelected( true );
            break;
        default:
            _splPaletteColors64Choice.setSelected( true );
            break;
        }
    }

}
