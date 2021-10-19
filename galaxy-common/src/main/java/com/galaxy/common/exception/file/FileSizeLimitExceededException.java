package com.galaxy.common.exception.file;

/**
 * <p>文件名大小限制异常类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 12:11
 */
public class FileSizeLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    public FileSizeLimitExceededException(long defaultMaxSize)
    {
        super("upload.exceed.maxSize", new Object[] { defaultMaxSize });
    }
}
