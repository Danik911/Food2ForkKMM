package com.example.food2forkkmm.domain.util

import com.example.food2forkkmm.domain.model.GenericMessageInfo


/*We can't use an extension fun because KMM does not support this yet*/
class GenericMessageInfoQueueUtil() {

    /*Check whether there are duplicates of GenericMessageInfo in the queue*/
    fun doesMessageAlreadyExistInQueue(
        queue: Queue<GenericMessageInfo>,
        messageInfo: GenericMessageInfo
    ): Boolean {

        for (item in queue.items) {
            if (item.id == messageInfo.id) {
                return true
            }
        }
        return false
    }


}