package mg.ispm.musdoc.repository

import mg.ispm.musdoc.UserModel

/**
 * In-memory store for test results.
 * Pro next step: persist with Room / DataStore.
 */
object ScoreStore {
    val scores: ArrayList<UserModel> = arrayListOf()
}
