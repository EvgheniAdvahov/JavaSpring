package ru.gb.hw5_note.model;

import lombok.Getter;

@Getter
public enum Status {
        NOT_STARTED("не начата"),
        IN_PROGRESS("в процессе"),
        COMPLETED("завершена");

        private final String noteDescription;

        Status(String noteDescription){
                this.noteDescription = noteDescription;
        }

        public String getNoteDescription() {
                return noteDescription;
        }
}
