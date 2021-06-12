package awais.instagrabber.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.test.ext.junit.runners.AndroidJUnit4
import awais.instagrabber.db.dao.AccountDao
import awais.instagrabber.db.datasources.AccountDataSource
import awais.instagrabber.db.entities.Account
import awais.instagrabber.db.repositories.AccountRepository
import awais.instagrabber.repositories.*
import awais.instagrabber.repositories.responses.*
import awais.instagrabber.webservices.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ProfileFragmentViewModelTest {
    private val userService = object : UserService {
        override suspend fun getUserInfo(uid: Long): WrappedUser {
            TODO("Not yet implemented")
        }

        override suspend fun getUsernameInfo(username: String): WrappedUser {
            TODO("Not yet implemented")
        }

        override suspend fun getUserFriendship(uid: Long): FriendshipStatus {
            TODO("Not yet implemented")
        }

        override suspend fun search(timezoneOffset: Float, query: String): UserSearchResponse {
            TODO("Not yet implemented")
        }
    }

    private val friendshipService = object : FriendshipService {
        override suspend fun change(action: String, id: Long, form: Map<String, String>): FriendshipChangeResponse {
            TODO("Not yet implemented")
        }

        override suspend fun toggleRestrict(action: String, form: Map<String, String>): FriendshipRestrictResponse {
            TODO("Not yet implemented")
        }

        override suspend fun getList(userId: Long, type: String, queryParams: Map<String, String>): String {
            TODO("Not yet implemented")
        }

        override suspend fun changeMute(action: String, form: Map<String, String>): FriendshipChangeResponse {
            TODO("Not yet implemented")
        }
    }

    private val storiesService = object : StoriesService {
        override suspend fun fetch(mediaId: Long): String {
            TODO("Not yet implemented")
        }

        override suspend fun getFeedStories(): String {
            TODO("Not yet implemented")
        }

        override suspend fun fetchHighlights(uid: Long): String {
            TODO("Not yet implemented")
        }

        override suspend fun fetchArchive(queryParams: Map<String, String>): String {
            TODO("Not yet implemented")
        }

        override suspend fun getUserStory(url: String): String {
            TODO("Not yet implemented")
        }

        override suspend fun respondToSticker(storyId: String, stickerId: String, action: String, form: Map<String, String>): StoryStickerResponse {
            TODO("Not yet implemented")
        }

        override suspend fun seen(queryParams: Map<String, String>, form: Map<String, String>): String {
            TODO("Not yet implemented")
        }
    }

    private val mediaService = object : MediaService {
        override suspend fun fetch(mediaId: Long): MediaInfoResponse {
            TODO("Not yet implemented")
        }

        override suspend fun fetchLikes(mediaId: String, action: String): LikersResponse {
            TODO("Not yet implemented")
        }

        override suspend fun action(action: String, mediaId: String, signedForm: Map<String, String>): String {
            TODO("Not yet implemented")
        }

        override suspend fun editCaption(mediaId: String, signedForm: Map<String, String>): String {
            TODO("Not yet implemented")
        }

        override suspend fun translate(form: Map<String, String>): String {
            TODO("Not yet implemented")
        }

        override suspend fun uploadFinish(retryContext: String, queryParams: Map<String, String>, signedForm: Map<String, String>): String {
            TODO("Not yet implemented")
        }

        override suspend fun delete(mediaId: String, mediaType: String, signedForm: Map<String, String>): String {
            TODO("Not yet implemented")
        }

        override suspend fun archive(mediaId: String, signedForm: Map<String, String>): String {
            TODO("Not yet implemented")
        }
    }

    private val graphQLService = object : GraphQLService {
        override suspend fun fetch(queryParams: Map<String, String>): String {
            TODO("Not yet implemented")
        }

        override suspend fun getUser(username: String): String {
            TODO("Not yet implemented")
        }

        override suspend fun getPost(shortcode: String): String {
            TODO("Not yet implemented")
        }

        override suspend fun getTag(tag: String): String {
            TODO("Not yet implemented")
        }

        override suspend fun getLocation(locationId: Long): String {
            TODO("Not yet implemented")
        }
    }

    private val accountDao = object : AccountDao{
        override suspend fun getAllAccounts(): List<Account> {
            TODO("Not yet implemented")
        }

        override suspend fun findAccountByUid(uid: String): Account? {
            TODO("Not yet implemented")
        }

        override suspend fun insertAccounts(vararg accounts: Account) {
            TODO("Not yet implemented")
        }

        override suspend fun updateAccounts(vararg accounts: Account) {
            TODO("Not yet implemented")
        }

        override suspend fun deleteAccounts(vararg accounts: Account) {
            TODO("Not yet implemented")
        }

        override suspend fun deleteAllAccounts() {
            TODO("Not yet implemented")
        }
    }

    @Test
    fun testNoUsernameNoCurrentUser() {
        val state = SavedStateHandle(
            mutableMapOf<String, Any>(
                "username" to ""
            )
        )
        val userRepository = UserRepository(userService)
        val friendshipRepository = FriendshipRepository(friendshipService)
        val storiesRepository = StoriesRepository(storiesService)
        val mediaRepository = MediaRepository(mediaService)
        val graphQLRepository = GraphQLRepository(graphQLService)
        val accountDataSource = AccountDataSource(accountDao)
        val accountRepository = AccountRepository(accountDataSource)
        val viewModel = ProfileFragmentViewModel(
            state,
            userRepository,
            friendshipRepository,
            storiesRepository,
            mediaRepository,
            graphQLRepository,
            accountRepository,
        )
    }
}