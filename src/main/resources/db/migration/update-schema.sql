ALTER TABLE booking
DROP
FOREIGN KEY FKhacdq9bfa3r9xdimovsnonbyi;

ALTER TABLE booking
DROP
FOREIGN KEY FKkgseyy7t56x7lkjgu3wah5s3t;

CREATE TABLE booking2
(
    id                   BIGINT AUTO_INCREMENT NOT NULL,
    guest_name           VARCHAR(255) NULL,
    guestnid             VARCHAR(255) NULL,
    guest_contact_number VARCHAR(255) NULL,
    total_price DOUBLE NULL,
    days                 INT NULL,
    payment_method       VARCHAR(255) NULL,
    booking_time         datetime NULL,
    hotel_id             BIGINT NOT NULL,
    CONSTRAINT pk_booking2 PRIMARY KEY (id)
);

CREATE TABLE booking_room_counts
(
    booking_id BIGINT       NOT NULL,
    room_count INT NULL,
    room_type  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_booking_room_counts PRIMARY KEY (booking_id, room_type)
);

ALTER TABLE booking2
    ADD CONSTRAINT FK_BOOKING2_ON_HOTEL FOREIGN KEY (hotel_id) REFERENCES hotel (id);

ALTER TABLE booking_room_counts
    ADD CONSTRAINT fk_booking_room_counts_on_booking2 FOREIGN KEY (booking_id) REFERENCES booking2 (id);

DROP TABLE booking;

ALTER TABLE hotel
DROP
COLUMN category;

ALTER TABLE hotel
DROP
COLUMN `description`;

ALTER TABLE hotel
DROP
COLUMN image_path;

ALTER TABLE hotel
DROP
COLUMN room_options;

ALTER TABLE hotel_images
DROP
COLUMN images;

ALTER TABLE hotel
    MODIFY four_person_room_cost DECIMAL;

ALTER TABLE hotel
    MODIFY hotel_category INT NULL;

ALTER TABLE hotel
    MODIFY one_person_room_cost DECIMAL;

ALTER TABLE hotel
    MODIFY three_person_room_cost DECIMAL;

ALTER TABLE hotel
    MODIFY two_person_room_cost DECIMAL;

ALTER TABLE hotel
    MODIFY vip_suite_cost DECIMAL;