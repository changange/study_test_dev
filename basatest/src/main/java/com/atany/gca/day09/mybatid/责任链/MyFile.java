package com.atany.gca.day09.mybatid.责任链;

import lombok.Builder;
import lombok.Data;

/**
 * Author：耿常安
 * Date：2021-03-08-21:30
 * Description：<描述>
 */

@Data
@Builder
public class MyFile {
    private String fileName;
    private String filePath;
    private FileType fileType;
}
