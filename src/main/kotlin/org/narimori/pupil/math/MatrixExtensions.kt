package org.narimori.pupil.math

import org.joml.Matrix3fc
import org.joml.Matrix4dc
import org.joml.Matrix4f
import org.joml.Matrix4fc
import org.joml.Matrix4x3fc
import java.lang.Math

public inline fun matrix4f(block: Matrix4f.() -> Unit): Matrix4f = Matrix4f().apply(block)

public inline fun matrix4f(matrix: Matrix3fc, block: Matrix4f.() -> Unit): Matrix4f = Matrix4f(matrix).apply(block)

public inline fun matrix4f(matrix: Matrix4fc, block: Matrix4f.() -> Unit): Matrix4f = Matrix4f(matrix).apply(block)

public inline fun matrix4f(matrix: Matrix4x3fc, block: Matrix4f.() -> Unit): Matrix4f = Matrix4f(matrix).apply(block)

public inline fun matrix4f(matrix: Matrix4dc, block: Matrix4f.() -> Unit): Matrix4f = Matrix4f(matrix).apply(block)

public fun Matrix4f.rotateLocalXDegrees(degrees: Float): Matrix4f = rotateLocalX(degrees.toRadians())

public fun Matrix4f.rotateLocalYDegrees(degrees: Float): Matrix4f = rotateLocalY(degrees.toRadians())

public fun Matrix4f.rotateLocalZDegrees(degrees: Float): Matrix4f = rotateLocalZ(degrees.toRadians())

private fun Float.toRadians(): Float = Math.toRadians(toDouble()).toFloat()