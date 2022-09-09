package com.bignerdranch.android.tetris.helpers

/* вспомогательная функция генерации байтового массива */
fun array2dOfByte(sizeOuter: Int, sizeInner: Int): Array<ByteArray> =
    Array(sizeOuter) { ByteArray(sizeInner) }