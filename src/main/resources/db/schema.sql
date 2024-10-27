-- 참여자 정보 테이블 생성
CREATE TABLE participants (
                              id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '참여자 ID (고유 식별자)',
                              name VARCHAR(50) NOT NULL COMMENT '이름',
                              gender ENUM('M', 'F') NOT NULL COMMENT '성별 (M: 남자, F: 여자)',
                              birth_year YEAR NOT NULL COMMENT '출생 연도',
                              residence VARCHAR(100) NOT NULL COMMENT '거주지',
                              job VARCHAR(100) COMMENT '직업',
                              workplace_location VARCHAR(100) NOT NULL COMMENT '직장 근무지',
                              workplace_name VARCHAR(100) NOT NULL COMMENT '직장명',
                              height SMALLINT UNSIGNED COMMENT '키 (cm 단위)',
                              school_name VARCHAR(100) COMMENT '최종 졸업 학교명',
                              major VARCHAR(100) COMMENT '전공',
                              religion VARCHAR(50) COMMENT '종교',
                              note TEXT COMMENT '비고 (자유롭게 입력)',
                              profile_image VARCHAR(255) COMMENT '프로필 이미지 URL',
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '참여자 등록 일자',
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '정보 수정 일자'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='소개팅 참여자 정보 테이블';

-- 소개팅 매칭 정보 테이블 생성
CREATE TABLE matchings (
                           id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '매칭 ID (고유 식별자)',
                           male_participant_id BIGINT UNSIGNED NOT NULL COMMENT '남자 참여자 ID',
                           female_participant_id BIGINT UNSIGNED NOT NULL COMMENT '여자 참여자 ID',
                           matched_at DATE NOT NULL COMMENT '매칭 일자 (형식: YYYY-MM-DD)',
                           status ENUM('PENDING', 'IN_PROGRESS', 'SUCCESS', 'FAIL') NOT NULL DEFAULT 'PENDING' COMMENT '매칭 상태 (대기, 진행 중, 성공, 실패)',
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '매칭 생성 일자',
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '정보 수정 일자',

                           CONSTRAINT fk_male_participant FOREIGN KEY (male_participant_id) REFERENCES participants(id) ON DELETE CASCADE,
                           CONSTRAINT fk_female_participant FOREIGN KEY (female_participant_id) REFERENCES participants(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='소개팅 매칭 정보 테이블';


-- 사용자 정보 테이블 생성
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '사용자 ID',
                       username VARCHAR(50) UNIQUE NOT NULL COMMENT '사용자명(로그인 ID)',
                       password VARCHAR(255) NOT NULL COMMENT '암호화된 비밀번호',
                       email VARCHAR(100) UNIQUE COMMENT '이메일',
                       enabled BOOLEAN DEFAULT TRUE COMMENT '계정 활성화 여부',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일자',
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일자'
);

-- 역할 정보 테이블 생성
CREATE TABLE roles (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '역할 ID',
                       role_name VARCHAR(50) UNIQUE NOT NULL COMMENT '역할 이름(예: ROLE_USER, ROLE_ADMIN)',
                       description VARCHAR(100) COMMENT '역할 설명'
);

-- 사용자와 역할 매핑 테이블 생성
CREATE TABLE user_roles (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
                            user_id BIGINT NOT NULL COMMENT '사용자 ID',
                            role_id BIGINT NOT NULL COMMENT '역할 ID',
                            CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
                            CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE,
                            UNIQUE (user_id, role_id) COMMENT '유일한 사용자-역할 조합'
);