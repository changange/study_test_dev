package com.itany.admin;

import org.apache.kafka.clients.admin.AdminClient;

/**
 * Author：耿常安
 * Date：2021-03-21-13:22
 * Description：<描述>
 */
public interface AdminClientConsumer {

    void accept(AdminClient client) throws Exception;
}
