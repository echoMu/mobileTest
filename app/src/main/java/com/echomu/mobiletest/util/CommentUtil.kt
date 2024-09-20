package com.echomu.mobiletest.util

import com.blankj.utilcode.util.Utils
import java.io.ByteArrayOutputStream
import java.io.InputStream

/**
 * @author ehcoMu
 * @date 2024/9/20
 * @desc
 */
object CommentUtil {

    /**
     * 根据文件名称获取json串
     */
    fun getAssetsStingByName(fileName: String): String {
        var inputStream: InputStream? = null
        var bos: ByteArrayOutputStream? = null
        try {
            inputStream = Utils.getApp().assets.open(fileName)
            bos = ByteArrayOutputStream()
            val bytes = ByteArray(4 * 1024)
            var len = 0
            while (inputStream.read(bytes).also { len = it } != -1) {
                bos.write(bytes, 0, len)
            }
            return String(bos.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            inputStream?.close()
            bos?.close()
        }
        return ""
    }

}