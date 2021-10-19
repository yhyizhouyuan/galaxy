package com.galaxy.common.exception.file;

import com.galaxy.common.config.GalaxyConfig;
import com.galaxy.common.core.domain.BaseEntity;
import com.galaxy.common.exception.base.BaseException;
import com.galaxy.common.utils.DateUtils;
import com.galaxy.common.utils.StringUtils;
import com.galaxy.common.utils.file.FileUploadUtils;
import com.galaxy.common.utils.file.MimeTypeUtils;
import com.galaxy.common.utils.uuid.IdUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * <p>文件信息异常类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 12:15
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = -8823697956032290786L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }
}
