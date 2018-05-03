package com.slient.jobhelp.utils;

import com.slient.jobhelp.models.database.data.GroupQuestion;
import com.slient.jobhelp.models.database.data.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silent on 5/3/2018.
 */
public class DatabaseUtil {

    public static List<GroupQuestion> getAllGroupQuestion(){
        List<GroupQuestion> groupQuestions = new ArrayList<>();
        groupQuestions.add(new GroupQuestion("A","Realistic - Người thực tế",
                "Người thuộc nhóm sở thích nghề nghiệp này thường có khả năng về kỹ thuật, công nghệ, hệ thống; ưa thích làm việc với đồ vật, máy móc, động thực vật; thích làm các công việc ngoài trời.\n" +
                        "\n" +
                        "Ngành nghề phù hợp với nhóm này bao gồm những nghề về kiến trúc, an toàn lao động, nghề mộc, xây dựng, thủy sản, kỹ thuật, máy tàu thủy, lái xe, huấn luyện viên, nông - lâm nghiệp (quản lý trang trại, nhân giống cá, lâm nghiệp...), cơ khí (chế tạo máy, bảo trì và sửa chữa thiết bị, luyện kim, cơ khí ứng dụng, tự động...), điện - điện tử, địa lý - địa chất (đo đạc, vẽ bản đồ địa chính), dầu khí, hải dương học, quản lý công nghiệp..."));
        groupQuestions.add(new GroupQuestion("B","Investigative - Người nghiên cứu",
                "Có khả năng về quan sát, khám phá, phân tích đánh giá và giải quyết các vấn đề.\n" +
                        "\n" +
                        "Ngành nghề phù hợp với nhóm này bao gồm: Các ngành thuộc lĩnh vực khoa học tự nhiên (toán, lý, hóa, sinh, địa lý, địa chất, thống kê...); khoa học xã hội (nhân học, tâm lý, địa lý...); y - dược (bác sĩ gây mê, hồi sức, bác sĩ phẫu thuật, nha sĩ...); khoa học công nghệ (công nghệ thông tin, môi trường, điện, vật lý kỹ thuật, xây dựng...); nông lâm (nông học, thú y...)."));
        groupQuestions.add(new GroupQuestion("C","Artistic - Nghệ sỹ",
                "Có khả năng về nghệ thuật, khả năng về trực giác, khả năng tưởng tượng cao, thích làm việc trong các môi trường mang tính ngẫu hứng, không khuôn mẫu.\n" +
                        "\n" +
                        "Ngành nghề phù hợp với nhóm này bao gồm: Các ngành về văn chương; báo chí (bình luận viên, dẫn chương trình...); điện ảnh, sân khấu, mỹ thuật, ca nhạc, múa, kiến trúc, thời trang, hội họa, giáo viên dạy sử/Anh văn, bảo tàng, bảo tồn..."));
        groupQuestions.add(new GroupQuestion("D","Social - Xã hội",
                "Có khả năng về ngôn ngữ, giảng giải, thích làm những việc như giảng giải, cung cấp thông tin, sự chăm sóc, giúp đỡ, hoặc huấn luyện cho người khác.\n" +
                        "\n" +
                        "Ngành nghề phù hợp với nhóm này bao gồm: sư phạm; giảng viên; huấn luyện viên điền kinh; tư vấn - hướng nghiệp; công tác xã hội, sức khỏe cộng đồng, thuyền trưởng, thư viện, bác sĩ chuyên khoa, thẩm định giá, nghiên cứu quy hoạch đô thị, kinh tế gia đình, tuyển dụng nhân sự, cảnh sát, xã hội học, bà đỡ, chuyên gia về X-quang, chuyên gia dinh dưỡng...\n"));
        groupQuestions.add(new GroupQuestion("E","Enterprise - Thiên phú lãnh đạo",
                "Có khả năng về kinh doanh, mạnh bạo, dám nghĩ dám làm, có thể gây ảnh hưởng, thuyết phục người khác, có khả năng quản lý.\n" +
                        "\n" +
                        "Ngành nghề phù hợp với nhóm này bao gồm: Các ngành về quản trị kinh doanh (quản lý khách sạn, quản trị nhân sự...), thương mại, marketing, kế toán – tài chính, luật sư, dịch vụ khách hàng, tiếp viên hàng không, thông dịch viên, pha chế rượu, kỹ sư công nghiệp (ngành kỹ thuật hệ thống công nghiệp), bác sĩ cấp cứu, quy hoạch đô thị, bếp trưởng (nấu ăn), báo chí (phóng viên, biên tập viên...)..."));
        groupQuestions.add(new GroupQuestion("F","Conventional - Mẫu người công chức",
                "Có khả năng về số học, thích thực hiện những công việc chi tiết, thích làm việc với những số liệu, theo chỉ dẫn của người khác hoặc các công việc văn phòng.\n" +
                        "\n" +
                        "Ngành nghề phù hợp với nhóm này bao gồm: Các ngành nghề về hành chính, thống kê, thanh tra ngành, người giữ trẻ, điện thoại viên..."));
        return groupQuestions;
    }

    public static List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("Tôi có tính tự lập", "A"));
        questionList.add(new Question("Tôi suy nghĩ thực tế", "A"));
        questionList.add(new Question("Tôi là người thích nghi với môi trường mới", "A"));
        questionList.add(new Question("Tôi có thể vận hành, điều khiển các máy móc thiết bị", "A"));
        questionList.add(new Question("Tôi làm các công việc thủ công như gấp giấy, đan, móc", "A"));
        questionList.add(new Question("Tôi thích tiếp xúc với thiên nhiên, động vật, cây cỏ", "A"));
        questionList.add(new Question( "Tôi thích những công việc sử dụng tay chân hơn là trí óc", "A"));
        questionList.add(new Question( "Tôi thích những công việc thấy ngay kết quả", "A"));
        questionList.add(new Question("Tôi thích làmviệc ngoài trời hơn là trong phòng học, văn phòng", "A"));

        questionList.add(new Question( "Tôi có tìm hiểu khám phá nhiều vấn đề mới", "B"));
        questionList.add(new Question( "Tôi có khả năng phân tích vấn đề", "B"));
        questionList.add(new Question( "Tôi biết suy nghĩ một cách mạch lạc, chặt chẽ", "B"));
        questionList.add(new Question( "Tôi thích thực hiện các thí nghiệm hay nghiên cứu", "B"));
        questionList.add(new Question( "Tôi có khả năng tổng hợp, khái quát, suy đoán những vấn đề", "B"));
        questionList.add(new Question( "Tôi thích những hoạt động điều tra, phân loại, kiểm tra, đánh giá", "B"));
        questionList.add(new Question( "Tôi tự tổ chức công việc mình phái làm", "B"));
        questionList.add(new Question( "Tôi thích suy nghĩ về những vấn đề phức tạp, làm những công việc phức tạp\t", "B"));
        questionList.add(new Question( "Tôi có khả năng giải quyết các vấn đề", "B"));

        questionList.add(new Question( "Tôi là người dễ xúc động", "C"));
        questionList.add(new Question( "Tôi có óc tưởng tượng phong phú", "C"));
        questionList.add(new Question( "Tôi thích sự tự do, không theo những quy định , quy tắc", "C"));
        questionList.add(new Question( "Tôi có khả năng thuyết trình, diễn xuất", "C"));
        questionList.add(new Question( "Tôi có thể chụp hình hoặc vẽ tranh, trang trí, điêu khắc", "C"));
        questionList.add(new Question( "Tôi có năng khiếu âm nhạc", "C"));
        questionList.add(new Question( "Tôi có khả năng viết, trình bày những ý tưởng của mình", "C"));
        questionList.add(new Question( "Tôi thích làm những công việc mới, những công việc đòi hỏi sự sáng tạo", "C"));
        questionList.add(new Question( "Tôi thoải mái bộc lộ những ý thích", "C"));

        questionList.add(new Question( "Tôi là người thân thiện, hay giúp đỡ người khác", "D"));
        questionList.add(new Question( "Tôi thích gặp gỡ, làm việc với con người", "D"));
        questionList.add(new Question( "Tôi là người lịch sự, tử tế", "D"));
        questionList.add(new Question( "Tôi thích khuyên bảo, huấn luyện hay giảng giái cho người khác", "D"));
        questionList.add(new Question( "Tôi là người biệt lắng nghe", "D"));
        questionList.add(new Question( "Tôi thích các hoạt động chăm sóc sức khỏe của bản thân và người khác", "D"));
        questionList.add(new Question( "Tôi thích các hoạt độngvì mục tiêu chung của công đồng, xã hội", "D"));
        questionList.add(new Question( "Tôi mong muốn mình có thể đóng góp để xã hội tốt đẹp hơn", "D"));
        questionList.add(new Question( "Tôi mong muốn mình có thể đóng góp để xã hội tốt đẹp hơn", "D"));

        questionList.add(new Question( "Tôi là người có tính phiêu lưu, mạo hiểm", "E"));
        questionList.add(new Question( "Tôi có tính quyết đoán", "E"));
        questionList.add(new Question( "Tôi là người năng động", "E"));
        questionList.add(new Question( "Tôi có khả năng diễn đạt, tranh luận, và thuyết phục người khác", "E"));
        questionList.add(new Question( "Tôi thíc các việc quản lý, đánh giá", "E"));
        questionList.add(new Question( "Tôi thường đặt ra các mục tiêu, kế hoạch trong cuộc sống", "E"));
        questionList.add(new Question( "Tôi thích gây ảnh hưởng đến người khác", "E"));
        questionList.add(new Question( "Tôi là người thích cạnh tranh, và muốn mình giói hơn người khác", "E"));
        questionList.add(new Question( "Tôi muốn người khác phải kính trọng, nể phục tôi", "E"));

        questionList.add(new Question( "Tôi là người có đầu óc sắp xếp, tổ chức", "F"));
        questionList.add(new Question( "Tôi có tính cẩn thận", "F"));
        questionList.add(new Question( "Tôi là người chu đáo, chính xác và đáng tin cậy", "F"));
        questionList.add(new Question( "Tôi thích công việc tính toán sổ sách, ghi chép số liệu", "F"));
        questionList.add(new Question( "Tôi thíc các công việc lưu trữ, phân loại, cập nhất thông tin", "F"));
        questionList.add(new Question( "Tôi thường đặt ra những mục tiêu, kế hoạch trong cuộc sống", "F"));
        questionList.add(new Question( "Tôi thích dự kiến các khoản thu chi", "F"));
        questionList.add(new Question( "Tôi thích lập thời khóa biểu, sắp xếp lịch làm việc", "F"));
        questionList.add(new Question( "Tôi thích làm việc với các con số, làm việc theo hướng dẫn, quy trình", "F"));

        return questionList;
    }
}
