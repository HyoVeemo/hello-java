package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// ASSERTION 은 static import 하는 것이 좋다.
import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인이 적용되어야 하낟. ")
    void vip_o(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 1000);

        //then
        assertThat(discount).isEqualTo(100);
    }

    @Test
    @DisplayName("VIP 아니면 할인이 적용되면 안된다.")
    void vip_x(){
        //given
        Member member = new Member(1L,"memberBasic", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 1000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}