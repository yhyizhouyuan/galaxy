package com.galaxy.common.exception.file;

/**
 * <p>文件名称超长限制异常类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 14:18
 */
public class FileNameLengthLimitExceededException extends FileException
{
    private static final long serialVersionUID = -7117722927220249256L;

    public FileNameLengthLimitExceededException(int defaultFileNameLength)
    {
        super("upload.filename.exceed.length", new Object[] { defaultFileNameLength });
    }
}
