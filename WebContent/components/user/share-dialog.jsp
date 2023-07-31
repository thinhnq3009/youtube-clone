<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
<div
    class="modal fade AppLogin ShareDialog"
    id="staticBackdrop"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header align-items-start">
                <div>
                    <h5 class="modal-title" id="staticBackdropLabel">Chia sẻ video</h5>
                    <h6>Doremon - Nobita và xứ sở kỳ diệu</h6>
                </div>

                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                ></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="input-block">
                        <label for="username">Email</label>
                        <i class="left-icon bi bi-envelope-at"></i>
                        <input
                            class="input-control"
                            type="text"
                            name="username"
                            id="username"
                            placeholder="Username"
                        />
                    </div>
                    <div class="input-block">
                        <label for="username">Tin nhắn</label>
                        <i class="left-icon bi bi-card-text"></i>
                        <textarea
                            class="input-control"
                            type="text"
                            placeholder="Tin nhắn gửi tới người nhận"
                            rows="5"
                        ></textarea>
                    </div>
                    <div class="input-block d-flex justify-content-center mt-2">
                        <button type="submit">Gửi</button>
                    </div>
                </form>
                <h6 class="text-center">Hoặc</h6>
                <div class="input-group mb-3">
                    <input
                        type="text"
                        class="link-container"
                        value="https://www.youtube.com/watch?v=T93k6k0RvpM&t"
                    />
                    <button class="btn-copy" type="button" id="button-addon2">
                        Copy link
                    </button>
                </div>
            </div>
        
        </div>
    </div>
</div>
