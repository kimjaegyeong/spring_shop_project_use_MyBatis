package spring.project.shop.repository.memberrepository;

import spring.project.shop.domain.Member;

import java.util.List;

public interface MemberRepository {
    /*
    형변환에 대한 고민-> Member 뿐 아니라 추후 Item에 대해서도 Repository를 사용해야 하는데, 둘의 공통 interface를 만들고,
    반환을 Object로 설정하여 구체클래스에서 형변환하여 사용할것인지, 아니면 MemberRepository와 ItemRepository를 분리할 것인지.
    통합 Interface를 사용시에는 간결함, 단순성이 장점. 다만 Object의 형변환에서 성능적인 손해를 볼 수도 있음.
    Member와 Item의 Repository를 분리하는 경우에는 형변환을 하지 않아 런타임 시 형변환으로 인한 성능손해를 줄일 수 있음.
    결론적으로 분리하여 사용하기로 했는데, 이유는 Repository는 접근 빈도가 높아 장기적으로 보았을 때 형변환이 자주 일어날 수 밖에 없음.
    때문에 분리하여 사용
    */

    //Object --> Member로 교체
    public String save(Member member);

    public Member find(String id);

    public List<Member> findAll();

    public String remove(Member member);

    public String update(Member member);

    public void clearStore();
}
