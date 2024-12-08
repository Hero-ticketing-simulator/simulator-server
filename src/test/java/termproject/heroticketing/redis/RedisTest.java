package termproject.heroticketing.redis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    @Transactional
    void testRedisConnection() {
        // Redis에 값을 저장하고 가져오기 테스트
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();

        // Redis에 데이터 저장
        String testKey = "testKey";
        String testValue = "testValue";
        valueOps.set(testKey, testValue);

        // Redis에서 데이터 읽기
        String retrievedValue = valueOps.get(testKey);

        // 데이터 검증
        assertThat(retrievedValue).isNotNull();
        assertThat(retrievedValue).isEqualTo(testValue);
    }
}