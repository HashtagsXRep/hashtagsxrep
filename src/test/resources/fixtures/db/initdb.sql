INSERT INTO USER (id, nickname, name, token, secret, role, sign_in_date, system_creation_date, twitter_creation_date, followers, following, language, location, profile_image_url, verified, locked) VALUES ('4195957935', 'alextremp', 'Alex Castells \\uD83C\\uDFF4\\u200D\\u2620\\uFE0F\\uD83C\\uDF97 #XarxaRepublicana', '4195957935-zfVFDGUoIg3wC7koDjaDr278Ge6JWkS1fXsJv9z', 'dV2CE8W1TLaMXjX5sVTPNRsFuBJCrd8bGqZsV00SQhiVN', 'ADMIN', '2019-11-10 01:27:57', '2019-11-10 01:26:52', '2015-11-15 19:50:20', 11074, 10852, null, 'el Clot, Barcelona', 'https://pbs.twimg.com/profile_images/1188537371668701184/fNCazTM6_normal.jpg', 0, 0);

INSERT INTO POLL (id, author_id, description, creation_date, start_proposals_time, end_proposals_time, end_voting_time, start_event_time, end_ranking_time) VALUES ('6064d11b-7716-4aec-a792-29997927b40d', '4195957935', 'Atac #Test1', '2019-11-10 02:51:55', '2019-11-10 02:00:00', '2019-11-10 02:55:00', '2019-11-10 02:56:00', '2019-11-10 02:58:00', '2019-11-11 00:59:00');
INSERT INTO POLL (id, author_id, description, creation_date, start_proposals_time, end_proposals_time, end_voting_time, start_event_time, end_ranking_time) VALUES ('d6892ac4-26c4-4de9-aac5-a224e2f79c87', '4195957935', 'Atac #Test2', '2019-11-10 02:05:05', '2019-11-10 02:00:00', '2019-11-10 02:32:00', '2019-11-10 02:05:00', '2019-11-10 02:32:00', '2019-11-11 00:59:00');

INSERT INTO POLL_PROPOSAL (poll_id, author_id, hashtag, subject, cancelation_reason, moderator_nickname, creation_date) VALUES ('6064d11b-7716-4aec-a792-29997927b40d', '4195957935', '#TestHashtagsxrep1', '#TestHashtagsxrep test', null, null, '2019-11-10 02:52:14');
INSERT INTO POLL_PROPOSAL (poll_id, author_id, hashtag, subject, cancelation_reason, moderator_nickname, creation_date) VALUES ('d6892ac4-26c4-4de9-aac5-a224e2f79c87', '4195957935', '#TestHashtagsxrep2', '#TestHashtagsxrep test', null, null, '2019-11-10 02:29:21');

INSERT INTO POLL_INVITE (poll_id, nickname, reason) VALUES ('6064d11b-7716-4aec-a792-29997927b40d', 'alextremp', 'ADMIN');
INSERT INTO POLL_INVITE (poll_id, nickname, reason) VALUES ('d6892ac4-26c4-4de9-aac5-a224e2f79c87', 'alextremp', 'ADMIN');

INSERT INTO MONITOR (id, author_id, active, twitter_query, creation_date, end_date, last_update_date, next_query_string) VALUES ('d6892ac4-26c4-4de9-aac5-a224e2f79c87', '-1', 1, '#TestHashtagsxrep2', '2019-11-10 02:11:01', '2019-11-15 02:11:01', '2019-11-10 02:18:06', null);

INSERT INTO TWITTER_EXTRACTION (monitor_id, tweet_id, user_id, type, creation_date, interacted_status_id, interacted_user_id, language, text, ranked) VALUES ('d6892ac4-26c4-4de9-aac5-a224e2f79c87', '999999999999999', '4195957935', 'R', '2019-11-10 01:05:53', '1193085042102280192', '986949535560761347', 'es', 'test', 1);